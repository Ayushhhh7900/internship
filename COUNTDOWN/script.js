const calculateTime = () => {
    const targetDate = new Date("2025-02-01T00:00:00").getTime();
    const currentTime = Date.now();
    const remaining = targetDate - currentTime;

    if (remaining <= 0) {
        document.querySelector(".time-tracker").innerHTML = "<h2>The Wait is Over!</h2>";
        return;
    }

    const days = Math.floor(remaining / (1000 * 60 * 60 * 24));
    const hours = Math.floor((remaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((remaining % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((remaining % (1000 * 60)) / 1000);

    document.getElementById("dayCount").textContent = days;
    document.getElementById("hourCount").textContent = hours;
    document.getElementById("minuteCount").textContent = minutes;
    document.getElementById("secondCount").textContent = seconds;
};

setInterval(calculateTime, 1000);
