document.addEventListener('DOMContentLoaded', function() {
    // 当页面加载完毕后显示欢迎部分
    document.getElementById('top-section').classList.add('show');

    // 监听滚动事件
    window.addEventListener('scroll', function() {
        // 获取所有 section 元素
        var sections = document.querySelectorAll('section');

        // 遍历所有 section 元素
        sections.forEach(function(section) {
            // 如果某个 section 元素的顶部位置小于或等于窗口底部位置，则显示该元素
            if (section.getBoundingClientRect().top <= window.innerHeight) {
                section.classList.add('show');
            }
        });

        // 显示按钮
        document.querySelectorAll('button, .popup-content button').forEach(function(btn) {
            btn.style.display = 'block';
        });
    });
});

// 返回顶部函数
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' // 平滑滚动效果
    });
}

// Function to display confirmation modal
function showConfirmation(level, price) {
    var modal = document.getElementById("confirmationModal");
    modal.style.display = "block";
    // Pass level and price to the confirmation modal
    document.getElementById("confirmBtn").setAttribute("data-level", level);
    document.getElementById("confirmBtn").setAttribute("data-price", price);
}

// Close the modal when the close button is clicked
document.getElementsByClassName("close")[0].onclick = function() {
    var modal = document.getElementById("confirmationModal");
    modal.style.display = "none";
}

// Handle cancel button click
document.getElementById("cancelBtn").onclick = function() {
    var modal = document.getElementById("confirmationModal");
    modal.style.display = "none";
}

// Function to handle upgrade button click
function upgradeMembership(level, price) {
    showConfirmation(level, price);
}

// Handle confirm button click
document.getElementById("confirmBtn").onclick = function() {
    var level = this.getAttribute("data-level");
    var price = this.getAttribute("data-price");
    // Call backend API to upgrade membership
    fetch('/upgrade-membership', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ level: level, price: price })
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert("Membership upgraded successfully!");
                // Redirect to the original page
                window.location.href = "/original-page.html";
            } else {
                alert("Membership upgrade failed: " + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    var modal = document.getElementById("confirmationModal");
    modal.style.display = "none";
}
