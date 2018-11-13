/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author oddandre
 */
public class Module {
    String name;
    Integer id;
    String deadline;
    Integer tId;
    String learnGl;
    Teacher teach = new Teacher();

		
		public void setLearning_Goals(String learning_Goals) 
		{
			this.learning_Goals = learning_Goals;
		}
		

}