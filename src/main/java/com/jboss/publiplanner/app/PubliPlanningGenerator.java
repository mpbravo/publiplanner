package com.jboss.publiplanner.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jboss.publiplanner.domain.Block;
import com.jboss.publiplanner.domain.Channel;
import com.jboss.publiplanner.domain.CommercialAssignment;
import com.jboss.publiplanner.domain.Customer;
import com.jboss.publiplanner.domain.GoalChannelDayPart;
import com.jboss.publiplanner.domain.GoalPeriodTime;
import com.jboss.publiplanner.domain.PubliPlanning;
import com.jboss.publiplanner.domain.Video;

public class PubliPlanningGenerator {
	
	private static final Customer[] CUSTOMERS = {
			new Customer("CocaCola"),
	};
	
	private static final Channel[] CHANNELS = {
			new Channel("Telecinco"),
			new Channel("Cuatro"),
			new Channel("FDF"),
	};
	
	private static final GoalPeriodTime[] PTGOALS = {
			new GoalPeriodTime(CUSTOMERS[0], LocalDateTime.of(2016, 6, 1, 0, 0), LocalDateTime.of(2016, 6, 15, 23, 59), 20, 70),
			new GoalPeriodTime(CUSTOMERS[0], LocalDateTime.of(2016, 6, 16, 0, 0), LocalDateTime.of(2016, 6, 30, 23, 59), 10, 30),
	};
	
	private static final GoalChannelDayPart[] CDPGOALS = {
			new GoalChannelDayPart(CUSTOMERS[0], CHANNELS[0], 35, 25),
			new GoalChannelDayPart(CUSTOMERS[0], CHANNELS[1], 30, 10),
	};
	
	public PubliPlanning createPubliespPlanning(){
		PubliPlanning publiespPlanning = new PubliPlanning();
		createGoalsList(publiespPlanning);
		createBlockList(publiespPlanning);
		createVideoList(publiespPlanning);
		createCommercialsList(publiespPlanning);
		return publiespPlanning;
	}
	
	private void createCommercialsList(PubliPlanning publiespPlanning){
		List<CommercialAssignment> commercials = new ArrayList<CommercialAssignment>();
		//setting upper limit for assignments = number of available blocks
		for(int i = 0; i < 180; i++){
			commercials.add(new CommercialAssignment());
		}
		publiespPlanning.setCommercials(commercials);
	}
	
	private void createGoalsList(PubliPlanning publiespPlanning){
		List<GoalChannelDayPart> cdpGoals = new ArrayList<GoalChannelDayPart>();
		for (int i = 0; i < CDPGOALS.length; i++){
			cdpGoals.add(CDPGOALS[i]);
		}
		
		List<GoalPeriodTime> ptGoals = new ArrayList<GoalPeriodTime>();
		for (int i = 0; i < PTGOALS.length; i++){
			ptGoals.add(PTGOALS[i]);
		}
		
		publiespPlanning.setCdpGoals(cdpGoals);
		publiespPlanning.setPtGoals(ptGoals);
	}
	
	private void createVideoList(PubliPlanning publiespPlanning){
		List<Video> videoList = new ArrayList<Video>();
		videoList.add(new Video(CUSTOMERS[0], "Anuncio Largo", 20));
		videoList.add(new Video(CUSTOMERS[0], "Anuncio Corto", 10));
		publiespPlanning.setVideos(videoList);
	}
	
	//Simple example with one prime time block and one day time block each day
	private void createBlockList(PubliPlanning publiespPlanning){
		List<Block> blockList = new ArrayList<Block>();
		for (int i = 1; i <= 30; i++){
			blockList.add(new Block(CHANNELS[0],LocalDateTime.of(2016,6,i,10, 0), 180, 1));
			blockList.add(new Block(CHANNELS[0],LocalDateTime.of(2016,6,i,22, 0), 180, 2));
			
			blockList.add(new Block(CHANNELS[1],LocalDateTime.of(2016,6,i,10, 0), 180, 1));
			blockList.add(new Block(CHANNELS[1],LocalDateTime.of(2016,6,i,22, 0), 180, 2));
			
			blockList.add(new Block(CHANNELS[2],LocalDateTime.of(2016,6,i,10, 0), 180, 1));
			blockList.add(new Block(CHANNELS[2],LocalDateTime.of(2016,6,i,22, 0), 180, 2));
		}
		
		publiespPlanning.setBlocks(blockList);
		System.out.println("Lista de bloques: " + blockList.size());
	}

}
