package org.zerock.board.dto;

import lombok.ToString;

@ToString
public class PageRequestDTO {

    private int page = 1;
    private int size = 10;

   
    private String type;
    private String keyword;
    
    
    public String[] getArr() {

    	if(type == null || keyword == null) {
    		return null;
    	}
    	
    	return type.split("");
    }
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getOffset() {
        return (page - 1) * size;
    }

    public int getLimit() {
        return this.size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {

        if(page < 1) {
            page = 1;
            return;
        }

        if(page > 10000) {
            page = 100;
            return;
        }

        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {

        if(size < 1) {
            this.size = 10;
            return;
        }

        if(size > 100) {
            this.size = 100;
            return;
        }

        this.size = size;
    }


}
