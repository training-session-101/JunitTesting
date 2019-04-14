package unittest.deepstubs;

public class DeepStubs extends DeepStubDependent{

    /*DeepStubDependent deepStubDependent;

    public DeepStubDependent getDeepStubDependent() {
        return deepStubDependent;
    }

    public void setDeepStubDependent(DeepStubDependent deepStubDependent) {
        this.deepStubDependent = deepStubDependent;
    }*/

    public String methodUnderTest(String input) {
        return getDeepStubDependentDependent().getMessage(input);
    }

    public static void main(String[] args) {
        DeepStubs deepStubExample = new DeepStubs();
        //deepStubExample.setDeepStubDependent(new DeepStubDependent());
        //deepStubExample.getDeepStubDependent().setDeepStubDependentDependent(new DeepStubDependentDependent());
        System.out.println(deepStubExample.methodUnderTest("test"));
    }
}

class DeepStubDependent {

    DeepStubDependentDependent deepStubDependentDependent;

    public void setDeepStubDependentDependent(DeepStubDependentDependent deepStubDependentDependent) {
        this.deepStubDependentDependent = deepStubDependentDependent;
    }

    public DeepStubDependentDependent getDeepStubDependentDependent() {
        return deepStubDependentDependent;
    }
}

class DeepStubDependentDependent {
    String getMessage(String text) {
        return "message " + text;
    }
}
