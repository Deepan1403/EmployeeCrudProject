function submitForm(event) {
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

    fetch("http://localhost:8080/employee/adduser", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employeeResponse)
    })
    .then((response) => {
        if (response.status === 201) {
            alert("Employee Added Successfully");
            window.location.href = "Home.html";
        } else {
            console.error('Failed to add employee');
        }
    })
    .catch((error) => {
       console.error('Error adding employee: ' + error);
    });
}
