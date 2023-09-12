const dateSelectBtns = document.querySelectorAll('.date-select-btn');
const radioInputs = document.querySelectorAll('input[type=radio]');
globalThis.dateSelect = dateSelectBtns[0];
dateSelect.classList.add('selected-btn');

globalThis.radioLabel = radioInputs[0].parentNode;
radioLabel.classList.add('selected');

dateSelectBtns.forEach((dateSelectBtn) => {
    dateSelectBtn.addEventListener('click', function(e) {
        dateSelect.classList.remove('selected-btn');
        this.classList.add('selected-btn');
        dateSelect = this;
        applicantDate = this.dataset.applicantdate;
        makeApplicant(majorId, applicantDate).catch(reason => console.log(reason));
    })
})

radioInputs.forEach((radios) => {
        radios.addEventListener('change', function(){
            radioLabel.classList.remove('selected');
            radioLabel.style.marginRight = '0px';
            let margin = this.nextElementSibling.firstElementChild.clientWidth;
            this.parentNode.classList.add('selected');
            radioLabel = this.parentNode;

            let newMargin = this.nextElementSibling.firstElementChild.offsetWidth;
            margin = newMargin - margin < 0 ? 0 : newMargin - margin;
            radioLabel.style.marginRight = margin + 'px';
            majorId = this.dataset.id;
            makeApplicant(majorId, applicantDate).catch(reason => console.log(reason));

        });
    }
)



const close = () => {
    document.querySelector(".modal").classList.add("hidden");
    document.querySelector('#applicant').classList.add('hidden');
    document.querySelector('#cancel').classList.add('hidden');
}

document.querySelector(".closeBtn").addEventListener("click", close);
document.querySelectorAll(".cancel_button").forEach(btn => btn.addEventListener("click", close));