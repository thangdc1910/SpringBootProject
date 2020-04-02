/*import {deleteRequest} from "./utils";*/

const deleteEmpX = (empNo) => {
    alert(empNo);
    let row = document.getElementById(empNo);
    if (row) {
        row.remove();
    }
   /* let api = `/ba/cm/employee?empNo=${empNo}`;
    deleteRequest(api).then(response => {
        console.log(response)
    }).catch(error => console.log(error));
*/
}