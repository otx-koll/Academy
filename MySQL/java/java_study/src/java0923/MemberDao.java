package java0923;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import java0922.ActorVo;

public class MemberDao {

	public Connection getConnection() throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		Connection con = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dbUrl, dbId, dbPwd);

		return con;
	} // getConnection()

	// ȸ������ 1�� insert�ϱ�
	public int addMember(MemberVo memberVo) {
		int count = 0;

		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			sql = "INSERT INTO member (id, passwd, name, reg_date)";
			sql += "VALUES (?, ?, ?, now())";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPasswd());
			pstmt.setString(3, memberVo.getName());

			count = pstmt.executeUpdate();

			System.out.println(count + "�� ���� �߰�");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// ��ü ȸ����� ��������
	public List<MemberVo> getMembers() {
		List<MemberVo> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			sql = "SELECT * FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setId(rs.getString("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setReg_date(rs.getTimestamp("reg_date"));

				list.add(memberVo);
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} // getMembers()

	// Ư�� id�� �ش��ϴ� ȸ�� 1�� ��������
	public MemberVo getMemberById(String memberId) {
		MemberVo memberVo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			con = getConnection();

			sql = "SELECT * FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVo = new MemberVo();
				memberVo.setId(rs.getString("id"));
				memberVo.setPasswd(rs.getString("passwd"));
				memberVo.setName(rs.getString("name"));
				memberVo.setReg_date(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberVo;
	}

	// Ư�� id�� �ش��ϴ� ȸ���� �̸� �����ϱ�
	public void updateMemberById(MemberVo memberVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			con = getConnection();

			sql = "UPDATE member ";
			sql += "SET id = ? ";
			sql += "WHERE name = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getName());

			int count = pstmt.executeUpdate();
			
			System.out.println(count+"�� ���� ����");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ư�� id�� �ش��ϴ� ȸ�� 1�� �����ϱ�
	public int deleteMemberById(String id) {
		int count = 0;

		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			sql = "DELETE FROM member ";
			sql += "WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			count = pstmt.executeUpdate();

			System.out.println(count + "�� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// ��� ȸ�� �����ϱ�
	public int deleteAllMemberById() {
		int count = 0;

		String sql = "";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			sql = "DELETE FROM member";

			pstmt = con.prepareStatement(sql);

			count = pstmt.executeUpdate();

			System.out.println(count + "�� ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		List<MemberVo> list = memberDao.getMembers();

		for (MemberVo memberVo : list) {
			System.out.println(memberVo.toString());
		}
		System.out.println("����� ���� : " + list.size());

		MemberVo memberVo1 = memberDao.getMemberById("abc123");
		System.out.println("member : " + memberVo1);

		if (memberVo1 == null) {

		} else {

		}
		
		System.out.println("============ insert �׽�Ʈ ============");
		
		MemberVo memberVo3 = new MemberVo();
		memberVo3.setId("abc123");
		memberVo3.setPasswd("def123");
		memberVo3.setName("ȿ��");
		
		MemberVo memberVo4 = new MemberVo("asdf123","qwerty","�浿");
		MemberVo memberVo5 = new MemberVo("aaa12","bbb12","�ƹ���");

		// insert �׽�Ʈ
		memberDao.addMember(memberVo3);
		memberDao.addMember(memberVo4);
		memberDao.addMember(memberVo5);

		System.out.println("============ insert ��� Ȯ�� ============");

		MemberVo memberVoDb1 = memberDao.getMemberById(memberVo3.getId());
		MemberVo memberVoDb2 = memberDao.getMemberById(memberVo4.getId());
		MemberVo memberVoDb3 = memberDao.getMemberById(memberVo5.getId());

		System.out.println(memberVoDb1.toString());
		System.out.println(memberVoDb2.toString());
		System.out.println(memberVoDb3.toString());
		
		System.out.println("============ update �׽�Ʈ ============");
		memberVo3.setId("abcdefg1");
		
		memberDao.updateMemberById(memberVo3);
		
		System.out.println("============ update ��� Ȯ�� ============");
		
		MemberVo memberVodb3 = memberDao.getMemberById(memberVo3.getId());
		
		System.out.println(memberVodb3.toString());
		
		System.out.println("============ delete �׽�Ʈ ============");
		
		memberDao.deleteMemberById(memberVo3.getId());
		
		System.out.println("============ ��ü delete �׽�Ʈ ============");
		
		memberDao.deleteAllMemberById();
	}
}
