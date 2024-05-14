//import ju00.freeload.model.RestEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class RestDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public RestDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void readRest(RestEntity rest) {
//        String sql = "SELECT * from rest WHERE routeNm = ? AND gudClssCd = ?";
//        jdbcTemplate.query(sql, rest.getRouteNm(), rest.getGudClssCd());
//    }
//}