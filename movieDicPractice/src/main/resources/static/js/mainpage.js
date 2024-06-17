const urlLogin = "http://localhost:8080/user/login";
const urlLogout = "http://localhost:8080/user/logout";
const urlsignUp = "http://localhost:8080/user/signup";
const url = "http://localhost:8080/products";
const urlShow = "http://localhost:8080/user/show";

let userId = "";
let password = "";
let userName = "";
let userEmail = "";

$(".image a:gt(0)").hide();

setInterval(function () {
  $(".image a:first-child")
    .fadeOut(1000)
    .next("a")
    .fadeIn(1000)
    .end()
    .appendTo(".image");
}, 3000);

document.addEventListener("DOMContentLoaded", function () {
  sessionCheckForLogout();
});

function sessionCheckForLogout() {
  axios
    .get("http://localhost:8080/user/current", { withCredentials: true })
    .then((response) => {
      console.log("데이터:", response.data);
      if (response.status == 200) {
        const userId = response.data.userId;
        const authority = response.data.authority[0].authority;
        sessionStorage.setItem(
          "userInfo",
          JSON.stringify({ userId, authority })
        );

        // 사용자가 로그인한 상태일 때 로그아웃 버튼 표시
        const logoutBtn = document.getElementById("logoutBtn");
        logoutBtn.classList.remove("hidden"); // hidden 클래스 제거
        logoutBtn.addEventListener("click", logout);
      }
    })
    .catch((error) => {
      console.log("에러 발생:", error);
      alert("로그인해주세요.");
    });
}
