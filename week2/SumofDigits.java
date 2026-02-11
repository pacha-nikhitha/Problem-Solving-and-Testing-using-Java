public int sumOfSumsOfDigits(int input1) {

    String s = String.valueOf(input1);
    int n = s.length();

    int totalSum = 0;
    for (int i = 0; i < n; i++) {
        totalSum += s.charAt(i) - '0';
    }

    int result = 0;
    int currentSum = totalSum;

    for (int i = 0; i < n; i++) {
        result += currentSum;
        currentSum -= s.charAt(i) - '0';
    }

    return result;
}
