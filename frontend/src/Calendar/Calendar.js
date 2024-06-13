import React from 'react';
import PropTypes from 'prop-types';
import './Calendar.css';

function Calendar(props) {
    return (
        <div class="md:h-[93vh] w-full flex flex-col md:flex-row">
            <div class="md:basis-1/3 lg:basis-1/4 flex flex-col justify-start px-4 py-4 shadowCard">
                <h1 class="w-full basis-1/8 p-2 text-center font-thin text-4xl mb-16 mt-8">Дневник</h1>
                <div class="basis-3/4 w-full p-4 shadowCard rounded-xl flex flex-col justify-between">
                    <div class="">
                        <h1 class="text-offblack font-bold text-2xl">Недела 2</h1>
                        <h4 class="text-sm text-gray">22-26 Април</h4>
                    </div>
                    <textarea placeholder="Внесете дневник за неделата." class="h-[50vh] p-2 my-4 rounded-xl" />
                    <div class="text-white flex justify-end">
                        <button className="bg-red px-4 py-2 rounded-xl mr-2">
                            Откажи
                        </button>
                        <button class="bg-finkiO px-4 py-2 rounded-xl">
                            Зачувај
                        </button>
                    </div>
                </div>
            </div>
            <div class="md:basis-2/3 lg:basis-3/4 p-8 w-full md:w-fit mx-auto grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
                <div class="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div class="flex justify-between">
                        <h1 class="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div class="flex flex-col justify-center">
                            <h1 class="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea class="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
                <div className="flex flex-col shadowCard rounded-xl p-4 cardWeek">
                    <div className="flex justify-between">
                        <h1 className="rounded-full bg-gray text-[#f8f8f8] p-4 w-[6vh] h-[6vh] text-center">1</h1>
                        <div className="flex flex-col justify-center">
                            <h1 className="w-fit font-bold text-offblack">22-26 Април</h1>
                        </div>
                    </div>
                    <textarea className="rounded-xl mt-4 h-full cardTextArea p-2 text-sm" disabled
                              value="DABSHDSAHBJ"></textarea>
                </div>
            </div>
        </div>
    );
}


Calendar.propTypes = {};

Calendar.defaultProps = {};

export default Calendar;
