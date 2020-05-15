/*
*
*
* VM Memory
    Method area :In method area, all class level information like class name, immediate parent class name, methods and variables information etc.
                are stored, including static variables. There is only one method area per JVM, and it is a shared resource.

    Heap area :Information of all objects is stored in heap area. There is also one Heap Area per JVM. It is also a shared resource.

    Stack area :For every thread, JVM create one run-time stack which is stored here. Every block of this stack is called
                activation record/stack frame which store methods calls. All local variables of that method are stored in their corresponding frame.
                After a thread terminate, it’s run-time stack will be destroyed by JVM. It is not a shared resource.

    PC Registers :Store address of current execution instruction of a thread. Obviously each thread has separate PC Registers.

    Native method stacks :For every thread, separate native stack is created. It stores native method information.
*
*
* */


public class JVM {
}
