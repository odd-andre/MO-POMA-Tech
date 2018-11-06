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
    private String name;
    private Integer id;
    private Integer tId;
    private String deadline;
    private String learning_Goals;



	public Module (String name, String deadline, String learnGl, Integer id, Integer tId){

		this.deadline = deadline;
		this.id = id;
		this.learning_Goals = learnGl;
		this.tId = tId;
		this.name = name;
	}
     

		public String getName()
		{
			return name;
		}
		
		public Integer getId() 
		{
			return id;
		}
		
		public String deadline() 
		{
			return deadline;
		}
		
		public String getLearning_Goals() 
		{
			return learning_Goals;
		}
		
	
		
		public void setName(String jmeno) 
		{
			this.name = jmeno;
		}
		
		public void setId(Integer id) 
		{
			this.id = id;
		}
		
		public void setDeadline(String deadline) 
		{
			this.deadline = deadline;
		}
		

		
		public void setLearning_Goals(String learning_Goals) 
		{
			this.learning_Goals = learning_Goals;
		}
		

}