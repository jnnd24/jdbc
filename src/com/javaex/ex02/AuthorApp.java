package com.javaex.ex02;

import java.util.List;

public class AuthorApp {
	
	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();

		/*
		authorDao.authorInsert("김문열", "경북영양");
		authorDao.authorInsert("박경리", "경상남도 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert("기안84", "기안동에서 산84년생");
		authorDao.authorInsert("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert("김영하", "알쓸신잡");
		*/
		
		//insert 업그레이드버전
		
		
		
		
		
		
		//authorDao.authorDelete(2);
		
		//authorDao.authorUpdate(4, "이문열", "삼국지 작가");
		
		//authorDao.authorList;
		
		//List<authorVo> authorList = authorDao.authorList();
		
		List<AuthorVo> authorList = authorDao.authorSelect();
		for(int i = 0; i<authorList.size(); i++) {
			
			AuthorVo authorVo = authorList.get(i);
			System.out.println(authorVo.getAuthorId()
					+ ", " + authorVo.getAuthorName() + ", "
					+ authorVo.getAuthorDesc());
			
			
			/*
			int authorId = authorList.get(i).getAuthorId();
			//String authorName = authorList.get(i).getAuthorName();
			//String authorDesc = ;
			
			
			System.out.println(authorList.get(i).getAuthorId());
			*/
			
		}
		
		
	}

}
