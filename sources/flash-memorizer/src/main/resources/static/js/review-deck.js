<<<<<<< HEAD
const wrapper = document.querySelector(".wrapper"),
    flip_cards = document.querySelector(".flip_cards"),
    flip_card_frame = document.querySelectorAll(".flip_card_frame"),
    button = document.querySelectorAll(".flip_cards_button"),
    flip_card_index = document.querySelector(".flip_card_index"),
    flip_card_total = document.querySelector(".flip_card_total")
process_bar = document.querySelector(".process_bar");

console.log(wrapper, flip_cards, flip_card_frame, button, flip_card_index);

let cardIndex = 0, intervalId;

flip_card_total.innerHTML = flip_card_frame.length;

const autoSlide = () => {
    intervalId = setInterval(() => slideCard(++cardIndex),2000);
}

const slideCard = () => {
    console.log(cardIndex);
    cardIndex = cardIndex === flip_card_frame.length ? 0: cardIndex < 0 ? flip_card_frame.length - 1: cardIndex;
    flip_cards.style.transform = `translate(-${cardIndex*100}%)`
}

const updateClick = (e) => {
    clearInterval(intervalId);
    cardIndex += e.target.id === "next" ? 1 : -1;
    slideCard(cardIndex);
    console.log(cardIndex);
    flip_card_index.innerHTML = cardIndex + 1;
    process_bar.style.width = `${((cardIndex+1)/flip_card_frame.length)*100}%`
}

button.forEach((element) => element.addEventListener("click", updateClick));

wrapper.addEventListener("mouseover", ()=> clearInterval(intervalId))
wrapper.addEventListener("mouseleave", ()=> autoSlide)

function toggleFlip(card){
    card.classList.toggle("flipped");
}

function readContent(element) {
    var textToRead = element.querySelector('.flip_card_text').textContent;
    var speechSynthesis = window.speechSynthesis;
    var utterance = new SpeechSynthesisUtterance(textToRead);

    utterance.voice = speechSynthesis.getVoices().find(function(voice) {
        return voice.name === 'Google US English';
    });

    speechSynthesis.speak(utterance);
}

function readContentAndStopPropagation(event) {
    event.stopPropagation();
    readContent(event.target.closest('.flip_card_content'));
}
=======
var carousel = document.getElementById('carouselExampleCaptions');
carousel.addEventListener('slide.bs.carousel', function (event) {
    var currentSlide = event.to +1;
    var totalSlides = carousel.querySelectorAll('.carousel-item').length;
    var progress = (currentSlide / totalSlides) * 100;
    var progressBarIndicator = document.getElementById('progress-indicator');
    var progressBar = document.getElementById('progress-bar');
    var progressNumber = document.getElementById("progress-number");
    progressBar.style.width = progress + '%';
    progressBar.setAttribute('aria-valuenow', progress.toString());
    progressNumber.innerHTML = currentSlide + '/' + totalSlides;
});

function flipCard(card) {
  card.querySelector('.flip-card-inner').classList.toggle('flip-animation');
}


//modal
// modal for new proj
var modal_share = document.getElementById("modalshare");
function openModalShare() {
    modal_share.style.display = "flex";
}




const inputUserName = document.getElementById('inputUserName');
const listUsers = document.getElementById('listUsers');
var currentURL = window.location.href;
var matches = currentURL.match(/\/(\d+)$/);
var deck_ID = matches[1];
//
//
function closeModalShare() {
    modal_share.style.display = "none";
    inputUserName.value = '';
    listUsers.innerHTML='';
    document.getElementById('notifyNone').style.display = 'flex';
}
function GetUsers(data,callback){
    const GetUserNameUrl = 'http://localhost:8000/users/get-by-username';
    var options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json' // Đảm bảo đặt tiêu đề Content-Type là application/json
        }
    };

    fetch(GetUserNameUrl, options)
        .then(function(response) {
            return response.json(); // Trả về kết quả từ .json() để đảm bảo kết quả được chuyển tiếp
        })
        .then(callback)
        .catch(function(error) {
            console.log('Error');
        });
}

function  renderUser(user){
    var li = document.createElement("li");
    li.className="user__item";
    li.innerHTML = `
     <img src="https://trinhvantuyen.com/wp-content/uploads/2022/05/f410c21a9ac9b699e1ed83ff66e24cba.jpg" class="user__img">
     <div class="user__info">
     <p class="user__name">${user.username}</p>
     <p>${user.email}</p> 
     </div>
  `;
    listUsers.appendChild(li);
    li.addEventListener('click',function (){
        var data= {
            deck:{
                id:deck_ID
            },
            recipient:{
                id:user.id
            },
        }
        shareDeck(data);
    });
}

inputUserName.addEventListener('change', (event) => {
    listUsers.innerHTML='';
    const newValue =  event.target.value;
    GetUsers(newValue,renderUser);
    document.getElementById('notifyNone').style.display = 'none';
});

//
function shareDeck(data,callback){
    const ShareDeckUrl = 'http://localhost:8000/sharedDecks/add';
    var options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json' // Đảm bảo đặt tiêu đề Content-Type là application/json
        }
    };
    fetch(ShareDeckUrl, options)
        .then(function(response) {
            return response.json(); // Trả về kết quả từ .json() để đảm bảo kết quả được chuyển tiếp
        })
        .then(callback)
        .catch(function(error) {
            console.log('Error');
        });
}

function playSound(button) {
    const term = button.nextElementSibling.textContent; // Get the term from the sibling <h3> element

    fetch(`/play-audio?text=${encodeURIComponent(term)}`)
        .then(response => response.arrayBuffer())
        .then(async audioData => {
            const audioContext = new AudioContext();
            const audioBuffer = await audioContext.decodeAudioData(audioData);

            const source = audioContext.createBufferSource();
            source.buffer = audioBuffer;
            source.connect(audioContext.destination);
            source.start();
        })
        .catch(error => {
            console.error("Error playing audio:", error);
        });
}
>>>>>>> 564a774 (add multi choice test)
