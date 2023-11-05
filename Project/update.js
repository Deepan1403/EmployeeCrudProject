
const urlParams = new URLSearchParams(window.location.search);
const employeeId = urlParams.get('employeeId');

fetch("http://localhost:8080/employee/getbyid?employeeId="+employeeId)
  .then((response) => response.json())
  .then((employee) => {
    document.getElementById('firstName').value = employee.firstName;
    document.getElementById('lastName').value = employee.lastName;
    document.getElementById('email').value = employee.email;
    document.getElementById('department').value = employee.department;
    document.getElementById('position').value = employee.position;
    document.getElementById('salary').value = employee.salary;
    document.getElementById('dob').value = employee.dateOfBirth;
  })
  .catch((error) => {
    console.error("Error fetching employee details: " + error);
  });
  function submitForm(event, employeeId) {
    event.preventDefault(); 

    const employeeResponse = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        dateOfBirth: document.getElementById('dob').value,
        email: document.getElementById('email').value,
        department: document.getElementById('department').value,
        position: document.getElementById('position').value,
        salary: document.getElementById('salary').value
    };
  fetch("http://localhost:8080/employee/update?employeeId="+employeeId, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employeeResponse)
    })
    .then((response) => {
        if (response.status === 200) {
            console.log('Employee updated successfully');
            window.location.href="viewEmployee.html"
        } else {
            console.error('Failed to update employee');
        }
    })
    .catch((error) => {
        console.error('Error updating employee: ' + error);
    });
}