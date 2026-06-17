let n = document.getElementById("n");
let e = document.getElementById("e");
let p = document.getElementById("p");
// let api = "http://127.0.0.1:5050/signup";
let api = "https://c87c-218-248-4-14.ngrok-free.app/signup";
async function submit() {
  let user = {
    name: n.value,
    email: e.value,
    password: p.value,
  };

  let req = await fetch(api, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });
  let res = await req.text();
  console.log("\n\t res : " + res);
  console.log("\n\t data : " + user);
  console.log("\n\t data : " + JSON.stringify(user, null, 2));
}
