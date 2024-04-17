package com.unnoba.socialclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.unnoba.socialclub.entities.Member;
import com.unnoba.socialclub.entities.Charge;

public interface MemberRepository extends JpaRepository <Member, Integer>{
	
	@Query ("SELECT m FROM Member m WHERE m.name LIKE %?1% AND m.surname LIKE %?2% AND m.id = ?3 AND m.eliminado IS NULL")
	public List <Member> findAll (String nameKey, String surnameKey, Integer idKey);
	
	@Query ("SELECT m FROM Member m WHERE m.name LIKE %?1% AND m.surname LIKE %?2% AND m.eliminado IS NULL")
	public List <Member> findAllOption2(String nameKey, String surnameKey);  

	@Query ("SELECT m FROM Member m WHERE m.eliminado IS NULL")
	public List <Member> findAllMembers ();
	
	@Query ("SELECT m FROM Member m WHERE m.id= ?1")
	public Member findByMemberId(int id);
	
	@Query ("SELECT c FROM Charge c WHERE c.member_id= ?1")
	public List<Charge> memberCharges(Member member);
	
	@Query ("SELECT m FROM Member m WHERE (YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10) AND (m.name LIKE %?1% AND m.surname LIKE %?2%) AND m.eliminado IS NULL")
	public List <Member> findWithoutLifeMembersOption2 (String nameKey, String surnameKey);
	
	@Query ("SELECT m FROM Member m WHERE (YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10) AND (m.name LIKE %?1% AND m.surname LIKE %?2% AND m.id = ?3) AND m.eliminado IS NULL")
	public List <Member> findWithoutLifeMembers (String nameKey, String surnameKey, Integer idKey);
	
	@Query ("SELECT m FROM Member m WHERE YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10 AND m.eliminado IS NULL")
	public List <Member> findAllWithoutLifeMembers ();
	
	
	@Query("SELECT DISTINCT m FROM Member m " +
		       "WHERE (COALESCE((SELECT COUNT(c) FROM Charge c WHERE c.member_id = m), 0) = 0 " +
		       "OR (COALESCE(YEAR((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != YEAR(CURRENT_DATE) " +
		       "OR COALESCE(MONTH((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != MONTH(CURRENT_DATE)))"  +
			   "AND (YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10) AND m.eliminado IS NULL")
	public List<Member> debtMembers();

	
	
	@Query("SELECT DISTINCT m FROM Member m " +
		       "WHERE (COALESCE((SELECT COUNT(c) FROM Charge c WHERE c.member_id = m), 0) = 0 " +
		       "OR (COALESCE(YEAR((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != YEAR(CURRENT_DATE) " +
		       "OR COALESCE(MONTH((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != MONTH(CURRENT_DATE))) " +
		       "AND (m.name LIKE %?1% AND m.surname LIKE %?2%)" +
			   "AND (YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10) AND m.eliminado IS NULL")
	public List<Member> findDebtMembersByNameAndSurname(String nameKey, String surnameKey);
	
	@Query("SELECT DISTINCT m FROM Member m " +
		       "WHERE (COALESCE((SELECT COUNT(c) FROM Charge c WHERE c.member_id = m), 0) = 0 " +
		       "OR (COALESCE(YEAR((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != YEAR(CURRENT_DATE) " +
		       "OR COALESCE(MONTH((SELECT MAX(c.date) FROM Charge c WHERE c.member_id = m)), 0) != MONTH(CURRENT_DATE))) " +
		       "AND (m.name LIKE %?1% AND m.surname LIKE %?2% AND m.id = ?3)" +
			   "AND (YEAR(CURRENT_DATE) - YEAR(m.admission_date) < 10) AND m.eliminado IS NULL")
	public List<Member> findDebtMembersByNameSurnameAndKey(String nameKey, String surnameKey, Integer idKey);
	
	@Query("SELECT m FROM Member m WHERE YEAR(CURRENT_DATE) - YEAR(m.admission_date) >= 10 AND (m.name LIKE %?1% AND m.surname LIKE %?2%) AND m.eliminado IS NULL")
	public List<Member> findLifeMembersByNameAndSurname(String nameKey, String surnameKey);
	
	@Query("SELECT m FROM Member m WHERE YEAR(CURRENT_DATE) - YEAR(m.admission_date) >= 10 AND (m.name LIKE %?1% AND m.surname LIKE %?2% AND m.id = ?3) AND m.eliminado IS NULL")
	public List<Member> findLifeMembersByNameSurnameAndKey(String nameKey, String surnameKey, Integer idKey);
	
	@Query("SELECT m FROM Member m WHERE YEAR(CURRENT_DATE) - YEAR(m.admission_date) >= 10 AND m.eliminado IS NULL")
	public List<Member> findLifeMembers ();
	/* */
	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.eliminado = true WHERE m.id = ?1")
	void deleteById(int id);
	/* 
	@Transactional
	@Modifying
	@Query("DELETE Member m WHERE m.id = ?1")
	void deleteById(int id);
	*/
}
