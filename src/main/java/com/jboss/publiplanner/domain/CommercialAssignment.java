package com.jboss.publiplanner.domain;

import java.time.LocalDateTime;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class CommercialAssignment {
	
	//Planning variable
	private Video video;
	
	private int indexInVideo; // x out of y times we are playing
	
	//Planning variable
	private Block block;

	@PlanningVariable(valueRangeProviderRefs = {"videoRange"})
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getIndexInVideo() {
		return indexInVideo;
	}

	public void setIndexInVideo(int indexInVideo) {
		this.indexInVideo = indexInVideo;
	}
	
	@PlanningVariable(valueRangeProviderRefs = {"blockRange"}, nullable = true)
	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}
	
	// ************************************************************************
    // Complex methods
    // ************************************************************************
	
	public Channel getChannel() {
        return block == null ? null : block.getChannel();
    }
	
	public Customer getCustomer(){
		return video == null ? null : video.getCustomer();
	}
	
	public int getDuration(){
		return video == null ? 0 : video.getDuration();
	}
	
	public boolean isPrimeTime(){
		return block == null ? false : block.isPrimeTime();
	}
	
	public int getGrps(){
		return block == null ? 0 : block.getGrps();
	}
	
	public LocalDateTime getStart(){
		return block == null ? null : block.getStartingTime();
	}
	
	public boolean isInPeriod(LocalDateTime start, LocalDateTime end){
		return block == null ? false : block.isInPeriod(start, end);
	}
	
	public boolean isSameDay(LocalDateTime day){
		return block == null ? false : block.isSameDay(day);
	}
	
	public String toString(){
		if ((video != null) && (block != null)){
			return "Commercial Assignment: Video name: " + video.getName() + 
					" Channel: " + block.getChannel().getName() + 
					" Starting time: " + block.getStartingTime().toString() + 
					" Prime time " + isPrimeTime() + "\n";
		}
		else return "Not assigned";
	}
}
