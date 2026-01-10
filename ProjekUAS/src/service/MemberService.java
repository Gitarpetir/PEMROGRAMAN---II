package service;

import dao.MemberDAO;
import model.Member;

import java.util.ArrayList;

public class MemberService {

    private MemberDAO memberDAO = new MemberDAO();

    public void tambahMember(String nama, String alamat, String telepon) {
        Member m = new Member(nama, alamat, telepon);
        memberDAO.insert(m);
        }

    public void updateMember(int id, String nama, String alamat, String telepon) {
    	Member m = new Member(id, nama, alamat, telepon);
        memberDAO.update(m);
        }

    public void hapusMember(int id) {
        memberDAO.delete(id);
        }

    public ArrayList<Member> getSemuaMember() {
        return memberDAO.getAll();
        }

    public Member getMemberById(int id) {
        return memberDAO.getById(id);
        }
}
