package com.gal.model;                                                                           
                                                                                                 
import jakarta.persistence.*;                                                                    
import java.sql.Date;                                                                            
                                                                                                 
@Entity                                                                                          
@Table(name = "cab_allocation")                                                                  
public class CabAllocation {                                                                     
                                                                                                 
	@Id                                                                                          
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                          
    private int allocationId;                                                                    
                                                                                                 
    @ManyToOne                                                                                   
    @JoinColumn(name = "employee_id")                                                            
    private Employee employee;                                                                   
                                                                                                 
    @ManyToOne                                                                                   
    @JoinColumn(name = "cab_id")                                                                 
    private Cab cab;                                                                             
                                                                                                 
    @Column(name = "booking_date")                                                               
    private Date bookingDate;                                                                    
                                                                                                 
    private String time;                                                                         
                                                                                                 
    public int getAllocationId() {                                                               
		return allocationId;                                                                     
	}                                                                                            
                                                                                                 
	public void setAllocationId(int allocationId) {                                              
		this.allocationId = allocationId;                                                        
	}                                                                                            
                                                                                                 
	public Employee getEmployee() {                                                              
		return employee;                                                                         
	}                                                                                            
                                                                                                 
	public void setEmployee(Employee employee) {                                                 
		this.employee = employee;                                                                
	}                                                                                            
                                                                                                 
	public Cab getCab() {                                                                        
		return cab;                                                                              
	}                                                                                            
                                                                                                 
	public void setCab(Cab cab) {                                                                
		this.cab = cab;                                                                          
	}                                                                                            
                                                                                                 
	public Date getBookingDate() {                                                               
		return bookingDate;                                                                      
	}                                                                                            
                                                                                                 
	public void setBookingDate(Date bookingDate) {                                               
		this.bookingDate = bookingDate;                                                          
	}                                                                                            
                                                                                                 
	public String getTime() {                                                                    
		return time;                                                                             
	}                                                                                            
                                                                                                 
	public void setTime(String time) {                                                           
		this.time = time;                                                                        
	}                                                                                            
}                                                                                                