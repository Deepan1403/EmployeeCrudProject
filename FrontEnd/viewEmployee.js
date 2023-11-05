function populateTable(data) {
  const eventTable = document.getElementById("eventTable");

  eventTable.innerHTML = "";

  if (Array.isArray(data)) {
    const headerRow = eventTable.insertRow();
    const headers = ['employeeId', 'firstName', 'lastName', 'email', 'dateOfBirth', 'department', 'position', 'salary', 'delete', 'update'];

    headers.forEach((header) => {
        const headerCell = document.createElement("th");
        headerCell.innerHTML = header;
        headerRow.appendChild(headerCell);
    });

    data.forEach((employee) => {
        const row = eventTable.insertRow();

        const properties = ['employeeId', 'firstName', 'lastName', 'email', 'dateOfBirth', 'department', 'position', 'salary'];

        properties.forEach((property) => {
            const cell = row.insertCell();
            cell.innerHTML = employee[property];
        });

        const deleteButton = document.createElement("button");
        deleteButton.innerText = "Delete";
        deleteButton.addEventListener("click", () => handleDelete(employee.employeeId));
        row.insertCell().appendChild(deleteButton);

        const updateButton = document.createElement("button");
        updateButton.innerText = "Update";
        updateButton.addEventListener("click", () => handleUpdate(employee.employeeId));
        row.insertCell().appendChild(updateButton);
    });
} else if (typeof data === 'object') {
    const headerRow = eventTable.insertRow();
    const headers = ['employeeId', 'firstName', 'lastName', 'email', 'dateOfBirth', 'department', 'position', 'salary', 'delete', 'update'];

    headers.forEach((header) => {
        const headerCell = document.createElement("th");
        headerCell.innerHTML = header;
        headerRow.appendChild(headerCell);
    });

    const row = eventTable.insertRow();

    const properties = ['employeeId', 'firstName', 'lastName', 'email', 'dateOfBirth', 'department', 'position', 'salary'];

    properties.forEach((property) => {
        const cell = row.insertCell();
        cell.innerHTML = data[property];
    });

    const deleteButton = document.createElement("button");
    deleteButton.innerText = "Delete";
    deleteButton.addEventListener("click", () => handleDelete(data.employeeId));
    row.insertCell().appendChild(deleteButton);

    const updateButton = document.createElement("button");
    updateButton.innerText = "Update";
    updateButton.addEventListener("click", () => handleUpdate(data.employeeId));
    row.insertCell().appendChild(updateButton);
} else {
    console.error("Data is not in the expected format (array or object).");
}
}

fetch('http://localhost:8080/employee/alldata')

  .then((response) => response.json())
  .then((data) => {
      populateTable(data);
  })
  .catch((error) => {
      console.error("Error fetching data: " + error);
  });
 
  function handleDelete(employeeId) {
   
    fetch("http://localhost:8080/employee/delete?employeeId="+employeeId,{
      method:"DELETE"
    })
      .then((response) => {
        if (response.status=== 200) {
            window.location.reload()
        } else {
          console.error("Failed to delete employee.");
        }
      })
      .catch((error) => {
        console.error("Error deleting employee: " + error);
      });
  }
  
  function handleUpdate(employeeId) {
    window.location.href = `update.html?employeeId=${employeeId}`;
  }

  function searchEmployeesById() {
    const employeeId = document.getElementById("searchInput1").value;

    fetch('http://localhost:8080/employee/getbyid?employeeId='+employeeId)
    .then((response) => {
      if (response.status !== 302) {
          alert("Employee not found");
      } else {
          return response.json();
          window.location.reload()
      }
  })
    .then((data) => {
        populateTable(data)
        });
  }

  
  function searchEmployeesByName() {
    const employeeName = document.getElementById("searchInput2").value;

    fetch('http://localhost:8080/employee/getbyfirstname?employeeFirstName='+employeeName)
    .then((response) => {
      if (response.status !== 302) {
          alert("Employee not found");
          window.location.reload()
      } else {
          return response.json();
      }
  })
    .then((data) => {
        populateTable(data)
        });
  }