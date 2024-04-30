package com.green.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.CommentDto;
import com.green.repository.ArticleRepository;
import com.green.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	
	
	// 1. 댓글 조회
	public List<CommentDto> comments(Long articleId) {
		
		/*
		// 1. 댓글을 db 에서 조회, Entity 에 담는다
		List<Comments> commentList = commentRepository.findByArticleId(articleId);
		
		// 2. Entity -> Dto 로 변환
		List<CommentDto> dtos = new ArrayList<CommentDto>();
		for (int i = 0; i < commentList.size(); i++) {
			Comments c = commentList.get(i);
			CommentDto dto = CommentDto.createCommentDto(c);
			dtos.add(dto);
		}
		// 3. 결과를 반환
		
		return dtos;
	}
	 */
	return commentRepository.findByArticleId(articleId)
			.stream()
			.map(comment -> CommentDto.createCommentDto(comment))
			.collect(Collectors.toList());
	}
}
