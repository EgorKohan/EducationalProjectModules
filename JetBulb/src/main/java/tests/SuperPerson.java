package tests;

public class SuperPerson extends Person {

    private String superName;

    public SuperPerson() {
    }

    public SuperPerson(String name, String superName) {
        super(name);
        this.superName = superName;
    }

    public SuperPerson(String superName) {
        System.out.println("Hello 3");
        this.superName = superName;
    }

    public void sayHello() {
        System.out.println("Hello I'm a super user");
    }

    @Override
    protected void sayJustHello() {
        super.sayJustHello();
    }
}
