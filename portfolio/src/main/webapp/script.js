// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {

  const quotes = [
    "Red: If people were more kind and loving, then the world would be too.",  
    "Aram: I’m not saying I’m amazing, but sometimes I’m distinctly above average.",
    "Red: As a fugitive of justice, I prefer not to linger in hallways.",
    "Red: Wisdom is learning the boundaries of one’s designated lane.",
    "Red: Read the book, think positive, control your urges, and I’ll put your gift to good use.",
    "Red: You’re a good friend who takes more care of me than I deserve.",
    "Red:  Revenge isn’t a passion. It’s a disease. It eats at your mind and poisons your soul.",
    "Scottie: There’s a very fine line between love and hate.",
    "Red: Sins should be buried like the dead. Not that they may be forgotten but we may them and find our way forward nonetheless.",
    "Red: No matter what I tried to do, all I brought her was misery and violence.",
    "Red: As my grandmother said, it’s good to have friends in low places.",
    "Red: Leave the past in the past, Tom. Nothing good comes from digging up secrets.",
    "Red: Sometimes bad luck is the best luck you’ll ever have.",
    "Sinclair: Whoever you are, confronting it with violence, is no path to resolution.",
  ]
  
  // Pick a random greeting.
  const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Add it to the page.
  const quoteContainer = document.getElementById('greeting-container');
  quoteContainer.innerText = quote;
}


$(document).ready(function(){
  $(".navbar a").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
      const hash = this.hash;
      $('html, body')
        .animate({
        scrollTop: $(hash).offset().top
      }, 800);
    }
  });
});

$(window).scroll(function() {
  let scrollDistance = $(window).scrollTop() + 60; // 60 is the height of the navbar

  $('section').each(function(i) {
    let positionTop = $(this).position().top;
    let height = $(this).height();
    if (positionTop <= scrollDistance && positionTop + height > scrollDistance) {
      $('.navbar .menu li.active').removeClass('active');
      $('.navbar .menu li').eq(i).addClass('active');
    }
  });
}).scroll();
