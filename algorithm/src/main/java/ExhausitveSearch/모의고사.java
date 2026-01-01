package ExhausitveSearch;

import java.util.ArrayList;

public class 모의고사 {
    public static int[] solution(int[] answers) {
        int[] answer;

        // 수포자들의 답안 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞춘 문제 수를 기록할 배열
        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length])
                scores[0]++;
            if(answers[i] == pattern2[i % pattern2.length])
                scores[1]++;
            if(answers[i] == pattern3[i % pattern3.length])
                scores[2]++;
        }

        // 최고 점수를 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최고 점수를 얻은 수포자 찾기
        ArrayList<Integer> winners = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                winners.add(i + 1); // 수포자 번호는 1부터 시작
            }
        }

        answer = new int[winners.size()];

        for(int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }

        return answer;
    }
}
