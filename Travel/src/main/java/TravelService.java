import java.util.List;

public class TravelService {
    private final TravelDao dao = new TravelDao();

    public List<TravelVO> selectTravelAll(int page, int pageSize) {
        return dao.selectTravelAll(page, pageSize);
    }

    public List<TravelVO> getByDistrict(String district) {
        return dao.getByDistrict(district);
    }

    public List<TravelVO> searchByTitle(String keyword) {
        return dao.searchByTitle(keyword);
    }
}
