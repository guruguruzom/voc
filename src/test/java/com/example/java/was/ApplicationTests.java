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

        // 1. ��ü �Խñ� �� ��ȸ
        long boardsCount = vocRepository.count();
        System.out.println(boardsCount);
        // 2. ��ü �Խñ� ����Ʈ ��ȸ
        List<VocVo> boards = vocRepository.findAll();
        
    }
	
	
//	  @Autowired
//	    BoardRepository boardRepository;
//
//	    @Test
//	    void save() {
//
//	        // 1. �Խñ� �Ķ���� ����
//	        Board params = Board.builder()
//	                .title("1�� �Խñ� ����")
//	                .content("1�� �Խñ� ����")
//	                .writer("������")
//	                .hits(0)
//	                .deleteYn('N')
//	                .build();
//
//	        // 2. �Խñ� ����
//	        boardRepository.save(params);
//
//	        // 3. 1�� �Խñ� ���� ��ȸ
//	        Board entity = boardRepository.findById((long) 1).get();
//	        assertThat(entity.getTitle()).isEqualTo("1�� �Խñ� ����");
//	        assertThat(entity.getContent()).isEqualTo("1�� �Խñ� ����");
//	        assertThat(entity.getWriter()).isEqualTo("������");
//	    }

}
