package com.fastcampus.ch4;

public class PageHandler {

    private int totalPosts;  // 전체 게시물 수
    private int currentPage; // 현재 페이지 번호
    private int pageSize;    // 한 페이지당 게시물 수
    private int totalPages;  // 전체 페이지 수
    private int startPage;   // 시작 페이지 번호
    private int endPage;     // 끝 페이지 번호
    private boolean prev;    // 이전 페이지가 있는지 여부
    private boolean next;    // 다음 페이지가 있는지 여부

    public PageHandler(int totalPosts, int currentPage, int pageSize) {
        this.totalPosts = totalPosts;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        // 총 페이지 수 계산
        this.totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        // 현재 페이지가 전체 페이지를 초과하지 않도록 설정
        if (currentPage > totalPages) {
            this.currentPage = totalPages;
        }

        // 시작 페이지와 끝 페이지 계산 (10페이지씩 보여준다고 가정)
        int displayPageCount = 10;
        this.startPage = Math.max(1, currentPage - displayPageCount / 2);
        this.endPage = Math.min(totalPages, startPage + displayPageCount - 1);

        // 이전과 다음 버튼 활성화 여부 설정
        this.prev = startPage > 1;
        this.next = endPage < totalPages;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalPosts=" + totalPosts +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
