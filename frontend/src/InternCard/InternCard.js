import React from 'react';
import PropTypes from 'prop-types';
import './InternCard.css';
import {useNavigate} from "react-router-dom";
import check from "../assets/check.svg"
import testLogo from "../assets/image1.png"

const InternCard = () => {
const nav = useNavigate();



return (
    <div class="flex flex-col justify-center h-[88vh]">
        <div className='shadow-2xl rounded-xl w-fit mx-auto flex'>
        </div>
        <div class="flex flex-col lg:flex-row rounded-[40px] shadowCard w-full lg:w-8/12 mx-auto mt-8">
            <div class="basis-1/4 rounded-tl-[40px] rounded-bl-[40px] flex justify-center overflow-hidden bgLogoImage" style={{backgroundImage: `url(${testLogo})`}}>
                <div class="flex flex-col justify-center h-full w-full bgLogoBlur">
                    <div class="flex justify-center">
                        <img class="rounded-[30px] m-8 lg:m-0 w-2/12 lg:w-6/12 h-auto" src={testLogo}/>
                    </div>
                </div>
            </div>
            <div class="basis-3/4 flex flex-col p-8">
                <div class="flex justify-between">
                    <div class="flex flex-col">
                        <h1 class="font-bold text-xl lg:text-4xl">Software Engeneer</h1>
                        <h3 class="text-md lg:text-2xl font-thin">@ Netcetera</h3>
                    </div>
                    <div class="flex justify-center">
                        <div class="flex flex-col justify-center">
                            <h1 className="bg-offblack text-white w-fit p-2 px-4 text-lg md:text-2xl font-bold h-fit rounded-xl">3</h1>
                        </div>
                        <div className="flex flex-col justify-center">
                            <h1 className="text-offblack w-fit px-2 text-md md:text-xl font-bold h-fit">од 12 недели</h1>
                        </div>
                    </div>
                </div>
                <div class='flex mt-4 flex-wrap circles'>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                    <img class="rounded-full bg-green md:p-4 w-[12%]" src={check}/>
                </div>
                <div class="flex flex-col-reverse lg:flex-row justify-between rounded-xl shadow-xl shadowCard mt-4">
                    <div class="flex justify-evenly w-full p-4 lg:p-0">
                        <div class="flex flex-col justify-center">
                            <div class="rounded-full w-[20px] h-[20px] bg-red"></div>
                        </div>
                        <div className="flex flex-col justify-center">
                            <h1 class="ml-4 text-sm lg:text-2xl">Одобрува Координатор</h1>
                        </div>
                    </div>
                    <button onClick={() => nav("/calendar")} class="bg-finkiO px-8 py-4 rounded-xl text-white font-bold text-lg lg:text-2xl">Дневник</button>
                </div>
            </div>
        </div>
    </div>
    )
}


InternCard.propTypes = {};

InternCard.defaultProps = {};

export default InternCard;
