package com.jboss.publiplanner.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class PubliPlanning implements Solution<HardSoftScore>{
	
	private List<CommercialAssignment> commercials;
	
	private List<Video> videos;
	
	private List<Block> blocks;
	
	private List<GoalChannelDayPart> cdpGoals;
	
	private List<GoalPeriodTime> ptGoals;
	
    private HardSoftScore score;
    
    @PlanningEntityCollectionProperty
	public List<CommercialAssignment> getCommercials() {
		return commercials;
	}

	public void setCommercials(List<CommercialAssignment> commercials) {
		this.commercials = commercials;
	}
	
	@ValueRangeProvider(id = "videoRange")
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@ValueRangeProvider(id = "blockRange")
	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
	
	public List<GoalChannelDayPart> getCdpGoals() {
		return cdpGoals;
	}

	public void setCdpGoals(List<GoalChannelDayPart> cdpGoals) {
		this.cdpGoals = cdpGoals;
	}
	
	public List<GoalPeriodTime> getPtGoals() {
		return ptGoals;
	}

	public void setPtGoals(List<GoalPeriodTime> ptGoals) {
		this.ptGoals = ptGoals;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}
    
	// ************************************************************************
    // Complex methods
    // ************************************************************************
	
	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();
		facts.addAll(cdpGoals);
		facts.addAll(ptGoals);
		facts.addAll(blocks);
		facts.addAll(videos);
		return facts;
	}
	
	public int differentDays(){
		int days = 0;
		HashSet<LocalDateTime> noDupSet = new HashSet<LocalDateTime>();
		LocalDateTime day = null;
		for (int i = 0; i < commercials.size(); i ++){
			day = commercials.get(i).getStart();
			noDupSet.add(day);
		}
		return days;
	}

}
