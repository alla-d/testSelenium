package groovy

class NinoGenerator {
    static void main(String[] args) {
        //import org.apache.commons.lang3.RandomStringUtils;

/**
 * Generates random National Identification Number (NINO)
 * Number is divided to separate letter-number groups
 * In each group some combinations of letters are not allowed
 * @return String random NINO number formatted as "AB123456D"
 */

        def notAllowedFirstTwoChars = Arrays.asList("GB", "BG", "NK", "KN", "TN", "NT", "ZZ")

// Some letters can't be first and some can't be second
        String[] firstAllowed = ["A", "B", "C", "E", "G", "H", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "W", "X", "Y", "Z"]
        String[] secondAllowed = ["A", "B", "C", "E", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "W", "X", "Y", "Z"]

        def rand = new Random()
        def group1 = ""
        while ("".equals(group1) || notAllowedFirstTwoChars.contains(group1)) {
            group1 = firstAllowed[rand.nextInt(firstAllowed.length)] + secondAllowed[rand.nextInt(secondAllowed.length)]
        }
        def group2 = Math.round(Math.random() * 899999) + 100000

// Only certain characters can show up last
        String[] lastAllowed = ["A", "B", "C", "D"]
        def group3 = lastAllowed[rand.nextInt(lastAllowed.length)]

        def nino = group1 + group2 + group3
        //log.info "Generated NINO: " + nino

        //testRunner.testCase.setPropertyValue("randomNINO", nino)
        println nino
    }

}

