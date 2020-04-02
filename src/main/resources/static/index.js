/*import * as utils from "./utils.js";*/
/*import {getRequest} from "./utils";*/


window.onload = async () => {
    modal = document.getElementById("myModal");
    span = document.getElementsByClassName("close")[0];
    refreshData();
    /*    let response = await fetch(url);
        if (response.ok) {
            let employees = await response.json();
            if (employees.length > 0) {

            }
        } else {
            alert("HTTP_ERROR: " + response.status);
        }*/
}
const refreshData = async () => {
    let url = "/ba/cm/employees";
    let employees = await getRequest(url).then(response => {
        if (response.status === 401) {
            login();
        }
        return response.json() || [];
    }).catch(error => console.log(error));

    if (employees.length > 0) {
        let content = `
 <table style="width:100%">
    <tr>
        <th>EmpNo</th>
        <th>EmpName</th>
        <th>Position</th>
        <th>Action</th>
    </tr>`;
        for (let i in employees) {
            content = `${content}
            <tr id = "${employees[i].empNo}">
                <td>${employees[i].empNo}</td>
                <td>${employees[i].empName}</td>
                <td>${employees[i].position}</td>
                <td><a href="#" onclick="showUpdatePopup(${employees[i].empNo},'${employees[i].empName}','${employees[i].position}')">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="#" onclick="deleteEmp(${employees[i].empNo})">Delete</a>
                </td>
            </tr> `
        }

        content = `${content}</table>`;
        document.getElementById("content").innerHTML = content;
    }
}


const showUpdatePopup = async (id, name, position) => {
    // Get the button that opens the modal
    modal.style.display = "block";

    document.getElementById("upName").value = name;
    document.getElementById("upPosition").value = position;
    document.getElementById("upId").value = id;
    // Get the <span> element that closes the modal
    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}


const addEmployee = async () => {
    let name = document.getElementById("eName").value;
    let position = document.getElementById("ePosition").value;
    let employee = {
        empName: name,
        position: position
    }
    let api = "/ba/cm/employee";
    await postRequest(api, employee);
    await refreshData();
}

const updateEmployee = async () => {
    let name = document.getElementById("upName").value;
    let position = document.getElementById("upPosition").value;
    let empNo = document.getElementById("upId").value;
    let employee = {
        empNo: empNo,
        empName: name,
        position: position
    }
    let api = "/ba/cm/employee";
    await putRequest(api, employee);
    await refreshData();
    modal.style.display = "none";
}
const deleteEmp = async (empNo) => {
    let row = document.getElementById(empNo);
    if (row) {
        row.remove();
    }
    let api = `/ba/cm/employee?empNo=${empNo}`;
    await deleteRequest(api).then(response => {
        response.text().then(value => console.log(value));
    }).catch(error => console.log(error));
}

const login = () => {
    console.log("You need to login!");
}


const request = (method, url, data) => {
    let requestBody = {
        method: method,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    }

    return fetch(url, requestBody);
};

const getRequest = url => request("GET", url, undefined);
const postRequest = (url, data) => request("POST", url, data);
const putRequest = (url, data) => request("PUT", url, data);
const deleteRequest = (url) => request("DELETE", url, undefined);