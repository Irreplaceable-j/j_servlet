const SpeechRecognition =
    window.SpeechRecognition || window.webkitSpeechRecognition;

class speech{
  #isRecognize = true;
  #recognition;

  constructor(resultCallBackFnc) {
    this.#recognition = new SpeechRecognition();
    this.#recognition.continuous = true;

    this.#recognition.addEventListener('end', ev => {
      if (this.#isRecognize) {
        this.#recognition.start();
      }
    });


  }

  recognize(){
    this.#isRecognize = true;
    this.#recognition.start();
  }

  stop(){
    this.#isRecognize = false;
    this.#recognition.stop();
  }

  speak(text) {
    const synth = window.speechSynthesis;
    const utterThis = new SpeechSynthesisUtterance(text);
    utterThis.pitch = 0.5;
    utterThis.rate = 1;
    synth.speak(utterThis);

  }

}

export default Speech;








