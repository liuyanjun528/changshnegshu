package com.annaru.upms.im.rong.models.response;

import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.im.rong.models.chatroom.ChatroomMember;
import com.annaru.upms.im.rong.util.GsonUtil;
import java.util.List;

/**
 * listBlockChatroomUser返回结果
 */
public class ListBlockChatroomUserResult extends Result{
	/**
	 * 被封禁用户列表
	 *
	 */
	List<ChatroomMember> members;

	public ListBlockChatroomUserResult(Integer code, String msg, List<ChatroomMember> members) {
		super(code, msg);
		this.members = members;
	}

	public ListBlockChatroomUserResult(List<ChatroomMember> members) {
		this.members = members;
	}
	/**
	 * 获取members
	 *
	 * @return List
	 */
	public List<ChatroomMember> getMembers() {
		return this.members;
	}
	/**
	 * 设置members
	 *
	 */
	public void setMembers(List<ChatroomMember> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, ListBlockChatroomUserResult.class);
	}
}
