package groovyScripts

class UniqueNameWithData {
    static void main(String[] args) {

        def date = new Date().format("MMdd")
        def time = new Date().format("HHmmss")

        def name = "Name " + date + "_" + time
        println name
// testRunner.getTestCase().setPropertyValue("name", name); // Useful for SoapUI properties


    }
}