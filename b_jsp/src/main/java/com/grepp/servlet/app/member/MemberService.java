package com.grepp.servlet.app.member;

import com.grepp.servlet.app.auth.Principal;
import com.grepp.servlet.app.auth.Role;
import com.grepp.servlet.app.member.dto.MemberDto;
import com.grepp.servlet.infra.db.JdbcTemplate;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
    private final MemberDao memberDao = new MemberDao();

    public Principal authenticate(String userId, String password) {
        Connection conn = jdbcTemplate.getConnection();
        try{
            Optional<MemberDto> optional = memberDao.selectByIdAndPassword(conn, userId, password);
            if(optional.isEmpty()){
                return Principal.ANONYMOUS;
            }

            return new Principal(optional.get().getUserId(), List.of(Role.ROLE_USER), LocalDateTime.now());
        }finally {
            jdbcTemplate.close(conn);
        }
    }

}
