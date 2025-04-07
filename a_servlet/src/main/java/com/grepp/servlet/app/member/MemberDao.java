package com.grepp.servlet.app.member;

import com.grepp.servlet.app.auth.Role;
import com.grepp.servlet.app.member.dto.MemberDto;
import com.grepp.servlet.infra.exception.DataAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MemberDao {

    public Optional<MemberDto> selectByIdAndPassword(Connection conn, String id, String password) {
        String sql = "select * from member where user_id = ? and password = ?";

        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            MemberDto res = null;
            stmt.setString(1, id);
            stmt.setString(2, password);

            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    res = generateMemberDto(rset);
                }

                return Optional.ofNullable(res);
            }

        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    private MemberDto generateMemberDto(ResultSet rset) throws SQLException {
        MemberDto res = new MemberDto();
        res.setUserId(rset.getString("user_id"));
        res.setPassword(rset.getString("password"));
        res.setEmail(rset.getString("email"));
        res.setTell(rset.getString("tell"));
        res.setLeave(rset.getBoolean("is_leave"));
        res.setGrade(Role.valueOf(rset.getString("grade")));
        return res;
    }
}