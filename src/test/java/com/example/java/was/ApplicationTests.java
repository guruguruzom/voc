package com.example.java.was;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java.was.entity.VocVo;
import com.example.java.was.repository.VocRepository;

@SpringBootTest
class ApplicationTests {

	@Autowired
    private VocRepository vocRepository;

	@Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long boardsCount = vocRepository.count();
        System.out.println(boardsCount);
        // 2. 전체 게시글 리스트 조회
        List<VocVo> boards = vocRepository.findAll();
        
    }
	
	
//	  @Autowired
//	    BoardRepository boardRepository;
//
//	    @Test
//	    void save() {
//
//	        // 1. 게시글 파라미터 생성
//	        Board params = Board.builder()
//	                .title("1번 게시글 제목")
//	                .content("1번 게시글 내용")
//	                .writer("도뎡이")
//	                .hits(0)
//	                .deleteYn('N')
//	                .build();
//
//	        // 2. 게시글 저장
//	        boardRepository.save(params);
//
//	        // 3. 1번 게시글 정보 조회
//	        Board entity = boardRepository.findById((long) 1).get();
//	        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
//	        assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
//	        assertThat(entity.getWriter()).isEqualTo("도뎡이");
//	    }

}
