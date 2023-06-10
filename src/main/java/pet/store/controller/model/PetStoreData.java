package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
	  private Long petStoreId;
	  private String petStoreName;
	  private String petStoreAddress;
	  private String petStoreCity;
	  private String petStoreZip;
	  private String petStorePhone;
	  private Set<PetStoreCustomer> customers = new HashSet<>();
	  private Set<PetStoreEmployee> employees = new HashSet<>();
	  
	  public PetStoreData(PetStore petStore) {
		  petStoreId = petStore.getPetStoreId();
		  petStoreName = petStore.getPetStoreName();
		  petStoreAddress = petStore.getPetStoreAddress();
		  petStoreCity = petStore.getPetStoreCity();
		  petStoreZip = petStore.getPetStoreZip();
		  petStorePhone = petStore.getPetStorePhone();
		  
		  for(Customer customer : petStore.getCustomers()) {
			  customers.add(new PetStoreCustomer(customer));
		  }
		  
		  for(Employee employee : petStore.getEmployees()) {
			  employees.add(new PetStoreEmployee(employee));
		  }
	  }
	  
	 @Data
	 @NoArgsConstructor
	 public static class PetStoreCustomer{
		  private Long customerId;
		  private String customerFirstName;
		  private String customerLastName;
		  private String customerEmail;
		  
		  PetStoreCustomer(Customer customer){
			  PetStore petstore = new PetStore();
		  }
	 }
	 
	 @Data
	 @NoArgsConstructor
	 public static class PetStoreEmployee{
		  private Long employeeId;
		  private String employeeFirstName;
		  private String employeeLastName;
		  private String employeePhone;
		  private String employeeJobTitle;
		  
		  PetStoreEmployee(Employee employee){
			  Employee employees = new Employee();
		  }
	 }
}


