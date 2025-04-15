import java.util.List;
import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelService service = new TravelService();

        while (true) {
            System.out.println("\n===== 여행지 정보 시스템 =====");
            System.out.println("1. 전체 목록 보기 (페이지 단위)");
            System.out.println("2. 권역별 관광지 보기");
            System.out.println("3. 키워드로 검색");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("페이지 번호 입력: ");
                int page = sc.nextInt();
                List<TravelVO> list = service.selectTravelAll(page, 10);
                list.forEach(System.out::println);
            } else if (choice == 2) {
                System.out.print("권역 입력 (예: 수도권, 강원권): ");
                String district = sc.nextLine();
                List<TravelVO> list = service.getByDistrict(district);
                list.forEach(System.out::println);
            } else if (choice == 3) {
                System.out.print("검색어 입력 (예: 관광, 수목원): ");
                String keyword = sc.nextLine();
                List<TravelVO> list = service.searchByTitle(keyword);
                list.forEach(System.out::println);
            } else if (choice == 0) {
                System.out.println("종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        sc.close();
    }
}
