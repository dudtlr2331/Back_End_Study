class St2 {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();

        for (char ch : rsp.toCharArray()) {
            if (ch == '2') {
                answer.append('0'); // 가위 → 바위
            } else if (ch == '0') {
                answer.append('5'); // 바위 → 보
            } else if (ch == '5') {
                answer.append('2'); // 보 → 가위
            }
        }

        return answer.toString();
    }
}