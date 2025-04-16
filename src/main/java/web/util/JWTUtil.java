package web.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component // Spring 컨테이너에 빈 등록
public class JWTUtil {

    // 비밀키 알고리즘 : HS256알고리즘 , HS512알고리즘
    // private String secretKey = "인코딩된 HS512 비트 키";
    // (1) 개발자 임의로 지정한 키 : private String secretKey = "2C68318E352971113645CBC72861E1EC23F48D5BAA5F9B405FED9DDDCA893EB4";
    // (2) 라이브러리 이용한 임의(랜덤) 키 :
    // import java.security.Key;
    // Keys.secretKeyFor( SignatureAlgorithm.알고리즘명 );
    private Key secretKey = Keys.secretKeyFor( SignatureAlgorithm.HS256 );

    // [1] JWT 토큰 발급 , 사용자의 이메일을 받아서 토큰 만들기
    public String createToken( String memail ){
        return Jwts.builder()
                // 토큰에 넣을 내용물 , 로그인 성공한 회원의 이메일을 넣는다.
                .setSubject( memail )
                // 토큰이 발급된 날짜 , new Date() : 자바에서 제공하는 현재날짜 클래스
                .setIssuedAt( new Date() )
                // 토큰 만료시간 , 밀리초(1000/1) , new Date( System.currentTimeMillis() ) : 현재시간의 밀리초
                // new Date( System.currentTimeMillis() + ( 1000 * 초 * 분 * 시 ) )
                .setExpiration( new Date( System.currentTimeMillis() + ( 1000 * 60 * 60 * 24 ) ) )  // 1일 의 토큰 유지기간
                // 지정한 비밀키 로 암호화 한다.
                .signWith( secretKey )
                // 위 정보로 JWT 토큰 생성하고 반환한다.
                .compact();
    }

    // [2] JWT 토큰 검증
    public String validateToken(String token){
        try {
            Claims claims = Jwts.parser() // parse() : JWT토큰 검증하기 위한 함수
                    .setSigningKey(secretKey) // 검증하기 위한 비밀키 넣기
                    .build() // 검증 실행, 검증 실패시 예외 발생
                    .parseClaimsJws(token) // 검증할 토근 해석, 실패시 예외 발생
                    .getBody(); // 검증할 토큰 해석, 실패시 예외 발생
            return claims.getSubject();
        }catch (ExpiredJwtException e) {
            System.out.println();
        }catch (JwtException e){
            System.out.println(">>JWT 에러 :"+e);
        }
        return null;
    }


}