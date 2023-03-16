package com.weasy.user.board.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.weasy.user.util.Criteria;
import com.weasy.user.command.AuthorityVO;
import com.weasy.user.command.ReplyVO;
import com.weasy.user.command.TaskVO;
import com.weasy.user.command.TeamVO;
import com.weasy.user.command.noticeListVO;

@Mapper
public interface BoardMapper {
	
	/* 팀 */
	public int insertTeam(TeamVO vo);
	
	public ArrayList<TeamVO> getTeamList(String user_id);
	
	//user가 속한 팀 리스트와 권한을 함께 가지고 온다.
	public ArrayList<TeamVO> getTeamListWithRole(String user_id);
	
	public int getTeamNo(String teamName);
	
	//현재 팀에 추가되어있는 멤버 권한 리스트 가져오기
	public ArrayList<AuthorityVO> getTeamMember(TeamVO vo);
	
	//팀 닫기
	public int closeTeamStatus(int teamNo);
	
	/* 권한(팀원) */
	
	//팀원 추가 (권한 테이블)	
	public int addAuthority(AuthorityVO vo);
	
	//팀원 권한 조회	
	public AuthorityVO getAuthority(TeamVO vo);

	//기존에 있는 팀원인지 체크
	public int checkAuthority(AuthorityVO vo);
	
	//기존 팀원 정보 update
	public int updateAuthority(AuthorityVO vo);
	
	//기존 팀원 정보 delete
	public int deleteAuthority(int deletekey);
	
	//권한 authno얻기 (pk)
	public int getAuthNo(AuthorityVO vo);

	/* task */
	
	public int addTask(TaskVO vo);
	
	public ArrayList<TaskVO> getTaskList(TaskVO taskVo);
	
	public void updateTask(TaskVO taskVo);
	
	public void insertReply(ReplyVO replyVo);
	
	public TaskVO putTask(int taskNo);
	
	public ArrayList<ReplyVO> putReply(int taskNo);
	
	//공지사항 리스트 가져오기
	public ArrayList<noticeListVO> getNoticeList();
	//공지사항 게시글 수(페이징)
	public int getTotal(Criteria cri); //전체게시글 수 
	//공지사항 상세페이지 가져오기
	public ArrayList<noticeListVO> getDetailNotice(noticeListVO noticeVo);
	
	public void taskStatusChange(TaskVO taskVo);
	
	//task 할당자 변경
	public int updateTaskUser(TaskVO taskVo);
}











