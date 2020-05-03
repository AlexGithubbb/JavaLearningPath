class Book {
    private String title;
    private String author;


    public int hashCode() {
        int hash = 37;
        int code = 0;

        // Use title
        code = (title == null ? 0 : title.hashCode());
        hash = hash * 59 + code;


        // Use author
        code = (author == null ? 0 : author.hashCode());
        hash = hash * 59 + code;

        return hash;
    }

    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.hashCode());
        System.out.println(37 * 59 * 59);



    }
}