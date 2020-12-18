package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.exam.vo.NoticeVo;

public interface NoticeMapper {

	void addNotice(NoticeVo noticeVo);
	
	@Select("SELECT * FROM notice WHERE num = #{num}")
	NoticeVo getNoticeByNum(int num);
	
	void updateReadcount(int num);
	
	@Select("SELECT COUNT(*) FROM notice")
	int getCountAll();
	
	List<NoticeVo> getNotices(@Param("startRow") int startRow, @Param("pageSize") int pageSize);
	
	void updateBoard(NoticeVo noticeVo);
	
	@Delete("DELETE FROM notice WHERE num = #[num}")
	void deleteNoticeByNum(int num);

	@Delete("DELETE FROM notice")
	void deleteAll();
	
	// 우리가 수행하고있는 업데이트문장에서 re_ref랑 re_seq이다. updateAndAddReply의 update인 sql
	void updateReSeq(@Param("reRef") int reRef,
					 @Param("reSeq") int reSeq);

	int getCountBySearch(@Param("category") String category,
						 @Param("search") String search);
	
	List<NoticeVo> getNoticesBySearch(
			@Param("startRow") int startRow,
			@Param("pageSize") int pageSize,
			@Param("category") String category, 
			@Param("search") String search);
	
}
