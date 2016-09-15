package com.alacriti.hhs.vo;

public class PaginationVo {
int query_id;
int count;
int start;
int offset;
public PaginationVo(int query_id, int count, int start, int offset) {
	this.query_id = query_id;
	this.count = count;
	this.start = start;
	this.offset = offset;
}
public PaginationVo() {
}
public int getQuery_id() {
	return query_id;
}
public void setQuery_id(int query_id) {
	this.query_id = query_id;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getOffset() {
	return offset;
}
public void setOffset(int offset) {
	this.offset = offset;
}

}
