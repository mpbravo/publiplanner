package com.jboss.publiplanner.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.publiplanner.domain.CommercialAssignment;
import com.jboss.publiplanner.domain.PubliPlanning;

public class PlannerApp {

	protected static final Logger logger = LoggerFactory.getLogger(PlannerApp.class);
	
	public static final String SOLVER_CONFIG
    = "com/jboss/publiplanner/plannerSolverConfig.xml";
	
	public static void main(String[] args) {
		// Solver configuration
		SolverFactory<PubliPlanning> solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
	    Solver<PubliPlanning> solver = solverFactory.buildSolver();
	    
	    System.out.println("*****Solver configured");
	    
	    // Create uninitialized solution
	    PubliPlanning unsolved = new PubliPlanningGenerator().createPubliespPlanning();
	    System.out.println("*****Problem loaded");
	    
	    // Solve problem
	    System.out.println("*****Solving...");
	    PubliPlanning bestSolution = solver.solve(unsolved);
	    
	    // Display result
	    System.out.println("\nSolved planning:\n" + toDisplayString(bestSolution));
    }
	
	public static String toDisplayString(PubliPlanning publiespPlanning){
		StringBuilder displayString = new StringBuilder();
		for (CommercialAssignment commercial : publiespPlanning.getCommercials()){
			displayString.append(commercial.toString()).append("\n");
		}		
		return displayString.toString();
	}
}
