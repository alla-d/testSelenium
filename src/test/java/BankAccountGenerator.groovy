package testWeb

class BankAccountGenerator {
    static void main(String[] args) {
       /**
 * Generates random BankAccount
 * Number is divided to codeBank and number groups 
 */

def generatedBankAccount = Math.round(Math.random() * 89999999) + 10000000
def codeBank = "010013"

def account = codeBank + generatedBankAccount
        //it can be useful for SoapUI groovy script
//log.info "Generated account number: " + account
//testRunner.testCase.setPropertyValue("BankAccountNumber", account)
        println account
    }

}
