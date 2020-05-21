//package jdbc_2.transaction;
//
//import jdbc.utils.JDBCUtils;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TransactionTest2 {
//
//    public void updateCoffeeSales(HashMap<String, Integer> salesForWeek)
//            throws Exception {
//
//        PreparedStatement updateSales = null;
//        PreparedStatement updateTotal = null;
//
//        Connection con = JDBCUtils.getConnection3();
//
//        String updateString =
//                "update " + dbName + ".COFFEES " +
//                        "set SALES = ? where COF_NAME = ?";
//
//        String updateStatement =
//                "update " + dbName + ".COFFEES " +
//                        "set TOTAL = TOTAL + ? " +
//                        "where COF_NAME = ?";
//
//        try {
//            con.setAutoCommit(false);
//            updateSales = con.prepareStatement(updateString);
//            updateTotal = con.prepareStatement(updateStatement);
//
//            for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
//                updateSales.setInt(1, e.getValue().intValue());
//                updateSales.setString(2, e.getKey());
//                updateSales.executeUpdate();
//                updateTotal.setInt(1, e.getValue().intValue());
//                updateTotal.setString(2, e.getKey());
//                updateTotal.executeUpdate();
//                con.commit();
//            }
//        } catch (SQLException e ) {
//            JDBCTutorialUtilities.printSQLException(e);
//            if (con != null) {
//                try {
//                    System.err.print("Transaction is being rolled back");
//                    con.rollback();
//                } catch(SQLException excep) {
//                    JDBCTutorialUtilities.printSQLException(excep);
//                }
//            }
//        } finally {
//            if (updateSales != null) {
//                updateSales.close();
//            }
//            if (updateTotal != null) {
//                updateTotal.close();
//            }
//            con.setAutoCommit(true);
//        }
//    }
//}
//
//
