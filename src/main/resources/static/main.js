async function fetchPatients() {
  const response = await fetch("http://localhost:8080/patients");
  const data = await response.json();
  document.getElementById("patients").innerText = JSON.stringify(data, null, 2);
}

async function addDoctor() {
  const id = document.getElementById("doctorId").value;
  const name = document.getElementById("doctorName").value;
  const specialization = document.getElementById("doctorSpecialization").value;
  const workHours = document.getElementById("doctorWorkHours").value;
  const numberOfPatients = document.getElementById(
    "doctorNumberOfPatients"
  ).value;

  await fetch("http://localhost:8080/doctors", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&name=${name}&specialization=${specialization}&workHours=${workHours}&numberOfPatients=${numberOfPatients}`,
  });
}

async function addPatient() {
  const id = document.getElementById("patientId").value;
  const name = document.getElementById("patientName").value;
  const fees = document.getElementById("patientFees").value;

  await fetch("http://localhost:8080/patients", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&name=${name}&fees=${fees}`,
  });
}

async function addWorker() {
  const id = document.getElementById("workerId").value;
  const name = document.getElementById("workerName").value;
  const salary = document.getElementById("workerSalary").value;
  const position = document.getElementById("workerPosition").value;

  await fetch("http://localhost:8080/workers", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&name=${name}&salary=${salary}&position=${position}`,
  });
}

async function addNurse() {
  const id = document.getElementById("nurseId").value;
  const name = document.getElementById("nurseName").value;
  const doctorId = document.getElementById("nurseDoctorId").value;
  const salary = document.getElementById("nurseSalary").value;

  await fetch("http://localhost:8080/nurses", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&name=${name}&doctorId=${doctorId}&salary=${salary}`,
  });
}

async function addAppointment() {
  const id = document.getElementById("appointmentId").value;
  const doctorId = document.getElementById("appointmentDoctorId").value;
  const patientId = document.getElementById("appointmentPatientId").value;
  const date = document.getElementById("appointmentDate").value;

  await fetch("http://localhost:8080/appointments", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&doctorId=${doctorId}&patientId=${patientId}&date=${date}`,
  });
}

async function fetchAppointments() {
  const response = await fetch("http://localhost:8080/allappointment");
  const data = await response.json();
  document.getElementById("appointments").innerText = JSON.stringify(
    data,
    null,
    2
  );
}
async function fetchPatientsWithFeesAbove() {
  const minFees = document.getElementById("minFees").value;
  const response = await fetch(
    `http://localhost:8080/patients/fees-above?minFees=${minFees}`
  );
  const data = await response.json();
  document.getElementById("patientsWithFeesAbove").innerText = JSON.stringify(
    data,
    null,
    2
  );
}

async function fetchDoctorCountBySpecialization() {
  const minCount = document.getElementById("minSpecializationCount").value;
  const response = await fetch(
    `http://localhost:8080/doctors/specialization-count?minCount=${minCount}`
  );
  const data = await response.json();
  document.getElementById("doctorSpecializationCount").innerText =
    JSON.stringify(data, null, 2);
}

async function fetchAppointmentsWithPatientAndDoctor() {
  const response = await fetch(
    "http://localhost:8080/appointments/patient-doctor"
  );
  const data = await response.json();
  document.getElementById("appointmentsWithPatientAndDoctor").innerText =
    JSON.stringify(data, null, 2);
}

async function fetchDoctorsWithNurses() {
  const response = await fetch("http://localhost:8080/doctors/nurses");
  const data = await response.json();
  document.getElementById("doctorsWithNurses").innerText = JSON.stringify(
    data,
    null,
    2
  );
}

async function fetchPatientsByDoctor() {
  const doctorId = document.getElementById("doctorIdForPatients").value;
  const response = await fetch(
    `http://localhost:8080/patients/by-doctor?doctorId=${doctorId}`
  );
  const data = await response.json();
  document.getElementById("patientsByDoctor").innerText = JSON.stringify(
    data,
    null,
    2
  );
}

async function fetchTotalAppointments() {
  const response = await fetch("http://localhost:8080/appointments/total");
  const data = await response.text();
  document.getElementById("totalAppointments").innerText = data;
}

async function fetchTotalFeesByDoctor() {
  const response = await fetch("http://localhost:8080/doctors/total-fees");
  const data = await response.json();
  document.getElementById("totalFeesByDoctor").innerText = JSON.stringify(
    data,
    null,
    2
  );
}

async function fetchAverageWorkerSalary() {
  const response = await fetch("http://localhost:8080/workers/average-salary");
  const data = await response.text();
  document.getElementById("averageWorkerSalary").innerText = data;
}

async function fetchDoctorsWithAppointmentCount() {
  const response = await fetch(
    "http://localhost:8080/doctors/appointment-count"
  );
  const data = await response.json();
  document.getElementById("doctorsWithAppointmentCount").innerText =
    JSON.stringify(data, null, 2);
}
async function updatePatient() {
  const id = document.getElementById("updatePatientId").value;
  const name = document.getElementById("updatePatientName").value;
  const fees = document.getElementById("updatePatientFees").value;

  await fetch("http://localhost:8080/patients/update", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}&name=${name}&fees=${fees}`,
  });
}

async function deletePatient() {
  const id = document.getElementById("deletePatientId").value;

  await fetch("http://localhost:8080/patients/delete", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id=${id}`,
  });
}